package com.csumb.cst438.a1;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 *
 * @author Cian
 */
@Entity
public class Word
{
    private int id;
    private String word;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId()
    {
        return id;
    }
    public void setId(int x)
    {
        this.id = x;
    }
    public String getWord()
    {
        return word;
    }
    public void setWord(String x)
    {
        this.word = x;
    }
}
