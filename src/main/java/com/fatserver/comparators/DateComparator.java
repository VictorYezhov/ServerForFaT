package com.fatserver.comparators;

import com.fatserver.sendingForms.QuestionDTO;

import java.util.Comparator;

/**
 * Created by Victor on 07.03.2018.
 */
public class DateComparator implements Comparator<QuestionDTO> {

    @Override
    public int compare(QuestionDTO o1, QuestionDTO o2) {

        if(o1.getQuestion().getDateTime().before(o2.getQuestion().getDateTime()))
            return 1;
        else
            return -1;
    }
}
