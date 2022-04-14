import React from "react"
import { hydrate } from "react-dom"
import { createRoot } from "react-dom/client"
import "./index.css"
import { Provider as AppContextProvider } from "./contexts/AppContext"
import App from "./App"
import * as serviceWorker from "./serviceWorker"

const container = document.getElementById("root")
// @ts-ignore
if (container.hasChildNodes()) {
  hydrate(
    <AppContextProvider>
      <App />
    </AppContextProvider>,
    container
  )
} else {
  // @ts-ignore
  const root = createRoot(container)
  root.render(
    <AppContextProvider>
      <App />
    </AppContextProvider>
  )
}

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: http://bit.ly/CRA-PWA
serviceWorker.unregister()
