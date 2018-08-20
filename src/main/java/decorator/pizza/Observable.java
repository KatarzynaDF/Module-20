package com.kodilla.patterns2;

    public interface Observable {
        void registerObserver(Observer observer);
        void notifyObservers();
        void removeObserver(Observer observer);
    }

