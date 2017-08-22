package org.arpit.java2blog.model;

import java.util.List;

public class UserPage {
    private List<User> users;
    private int currentPageNumber;
    private int lastPageNumber;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public int getCurrentPageNumber() {
        return currentPageNumber;
    }

    public void setCurrentPageNumber(int currentPageNumber) {
        this.currentPageNumber = currentPageNumber;
    }

    public int getLastPageNumber() {
        return lastPageNumber;
    }

    public void setLastPageNumber(int lastPageNumber) {
        this.lastPageNumber = lastPageNumber;
    }
}
