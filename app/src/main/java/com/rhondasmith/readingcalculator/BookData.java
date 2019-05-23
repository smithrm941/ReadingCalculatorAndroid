package com.rhondasmith.readingcalculator;

public class BookData {
    private String title;
    private String author;
    private double numberOfPages;
    private double currentPage;
    private double numberOfDays;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(double numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public double getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(double currentPage) {
        this.currentPage = currentPage;
    }

    public double getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(double numberOfDays) {
        this.numberOfDays = numberOfDays;
    }
}
