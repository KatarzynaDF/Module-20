package com.kodilla.patterns2;

import java.util.ArrayList;
import java.util.List;

public class ModuleTopic implements Observable {

        private final List<String> message;
        private final List<Observer> observers;
        private final String name;

        public ModuleTopic( String name) {
            message = new ArrayList<>();
            observers = new ArrayList<>();
            this.name = name;
        }

        public void addPost(String post) {
            message.add(post);
            notifyObservers();
        }

        @Override
        public void registerObserver(Observer observer) {
            observers.add(observer);
        }

        @Override
        public void notifyObservers() {
            for (Observer observer : observers) {
                observer.update(this);
            }
        }

        @Override
        public void removeObserver(Observer observer) {
            observers.remove(observer);
        }

        public List<String> getMessage() {
            return message;
        }

        public String getName() {
            return name;
        }
    }
