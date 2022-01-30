package com.sgpark.simplecrud.model.common;

import java.util.ArrayList;

/**
 * 리스트에 페이징 기능을 더한 클래스
 * @param <T>
 */
public class PagingList<T> {
    /**
     * 페이지 네비게이션에서 한번에 표시되는 페이지 번호 개수
     */
    final int NAVIGATION_BUTTON_COUNT = 10;

    /**
     * 한 페이지 표시할 아이템 개수
     */
    final int PAGE_SIZE = 5;

    /**
     * 최대 페이지 번호
     */
    private int maxPageNumber;

    /**
     * 현재 페이지 번호
     */
    private int currentPageNumber;

    /**
     * 화면에 표시되는 시작 페이지 번호
     */
    private int startPageNumber;

    /**
     * 화면에 표시되는 마지막 페이지 번호
     */
    private int endPageNumber;

    /**
     * 이전 페이지로 이동 버튼 표시 상태
     */
    private boolean showPreviousButton;

    /**
     * 다음 페이지로 이동 표시 상태
     */
    private boolean showNextButton;

    /**
     * 아이템
     */
    private ArrayList<T> items;

    /**
     * 
     * @param currentPage 현재 페이지 번호
     * @param itemCount
     * @param items
     */
    public PagingList(int currentPage, int itemCount, ArrayList<T> items){

        //현재 페이지
        this.currentPageNumber = currentPage;

        //최대 페이지
        this.maxPageNumber = (int)Math.ceil((double)itemCount / PAGE_SIZE);

        //1~10: 1
        //11~20: 11
        //시작,마지막 페이지 번호
        this.startPageNumber = currentPage - (currentPage - 1) % NAVIGATION_BUTTON_COUNT;
        this.endPageNumber = Math.min(this.startPageNumber + (NAVIGATION_BUTTON_COUNT - 1),
                                      this.maxPageNumber);

        //이전,다음버튼 상태
        this.showPreviousButton = this.startPageNumber > 1;
        this.showNextButton = this.endPageNumber < this.maxPageNumber;

        //아이템
        this.items = items;
    }

    public int getMaxPageNumber() {
        return maxPageNumber;
    }

    public int getCurrentPageNumber() {
        return currentPageNumber;
    }

    public int getStartPageNumber() {
        return startPageNumber;
    }

    public int getEndPageNumber() {
        return endPageNumber;
    }

    public boolean isShowPreviousButton() {
        return showPreviousButton;
    }

    public boolean isShowNextButton() {
        return showNextButton;
    }

    public ArrayList<T> getItems() {
        return items;
    }
}
