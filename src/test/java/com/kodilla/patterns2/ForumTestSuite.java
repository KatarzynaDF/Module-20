package com.kodilla.patterns2;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class ForumTestSuite {

        @Test
        public void testUpdate() {
            //Given
            ModuleTopic problemwithTask1 = new ProblemsWithTasks();
            ModuleTopic examIssue1 = new ExamIssue();
            Mentor janKowalski = new Mentor("Jan Kowalski");
            Mentor janNowak = new Mentor("Jan Nowak");
            Mentor annaNowak = new Mentor("Anna Nowak");
            problemwithTask1.registerObserver(janKowalski);
            problemwithTask1.registerObserver(janNowak);
            examIssue1.registerObserver(annaNowak);
            examIssue1.registerObserver(janKowalski);

            //When
            problemwithTask1.addPost("I got problem with task1 ");
            problemwithTask1.addPost("Describe it");
            problemwithTask1.addPost("I think i cannot update my frontent");
            examIssue1.addPost("May I ask about my exam result");
            examIssue1.addPost("Sure! Let me check");

            //Then
            assertEquals(5, janKowalski.getUpdateCount());
            assertEquals(3, janNowak.getUpdateCount());
            assertEquals(2, annaNowak.getUpdateCount());
        }
    }

