package com.wf.amqp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author wf
 * @create 2020-08-27 21:54
 * @desc
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Book {
    private String bookName;
    private String author;
}
