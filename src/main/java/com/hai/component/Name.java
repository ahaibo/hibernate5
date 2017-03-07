package com.hai.component;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import java.io.Serializable;

/**
 * Created by as on 2017/3/1.
 */
@Embeddable
public class Name implements Serializable{
    private String first;
    private String last;
}
