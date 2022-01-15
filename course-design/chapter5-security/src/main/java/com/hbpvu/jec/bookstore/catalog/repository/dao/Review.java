package com.hbpvu.jec.bookstore.catalog.repository.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import com.hbpvu.jec.bookstore.commons.util.DateAudit;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * @author Devaraj Reddy, Date : 07-Nov-2020
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Review extends DateAudit {


    private String reviewId;

    private String productId;

    private String userId;


    private String userName;

    @Min(1)
    @Max(5)
    private double ratingValue;

    private String reviewMessage;

}
