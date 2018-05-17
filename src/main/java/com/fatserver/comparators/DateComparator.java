package com.fatserver.comparators;

import com.fatserver.dto.SendQuestionDTO;

import java.util.Comparator;

/**
 * Created by Victor on 07.03.2018.
 */
public class DateComparator implements Comparator<SendQuestionDTO> {

    @Override
    public int compare(SendQuestionDTO o1, SendQuestionDTO o2) {

        if(o1.getQuestion().getDateTime().before(o2.getQuestion().getDateTime()))
            return 1;
        else
            return -1;
    }
}
