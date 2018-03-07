package com.fatserver.comparators;

import com.fatserver.sendingForms.QuestionForm;

import java.util.Comparator;

/**
 * Created by Victor on 07.03.2018.
 */
public class DateComparator implements Comparator<QuestionForm> {

    @Override
    public int compare(QuestionForm o1, QuestionForm o2) {

        if(o1.getQuestion().getDateTime().before(o2.getQuestion().getDateTime()))
            return 1;
        else
            return -1;
    }
}
