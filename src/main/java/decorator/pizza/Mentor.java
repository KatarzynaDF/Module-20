package com.kodilla.patterns2;

public class Mentor implements Observer {

        private final String userName;
        private int updateCount;

        public Mentor(String userName) {
            this.userName = userName;
        }

        @Override
        public void update(ModuleTopic moduleTask) {
            System.out.println(userName + ": New messages in topic " + moduleTask.getName() + "\n"
                    + "(total: " + moduleTask.getMessage().size() + " messages)");
            updateCount++;
        }

        public String getUserName() {
            return userName;
        }

        public int getUpdateCount() {
            return updateCount;
        }
    }

