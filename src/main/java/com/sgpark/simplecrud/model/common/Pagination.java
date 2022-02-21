package com.sgpark.simplecrud.model.common;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

/**
 * 리스트에 페이징 기능을 더한 클래스
 * @param <T>
 */
public class Pagination<T> {

    /**
     * 최대 페이지 번호
     */
    @Getter
    @Setter
    private int maxPageNumber;

    /**
     * 현재 페이지 번호
     */
    @Getter
    @Setter
    private int currentPageNumber;

    /**
     * 화면에 표시되는 시작 페이지 번호
     */
    @Getter
    @Setter
    private int startPageNumber;

    /**
     * 화면에 표시되는 마지막 페이지 번호
     */
    @Getter
    @Setter
    private int endPageNumber;

    /**
     * 이전 페이지로 이동 버튼 표시 상태
     */
    @Getter
    @Setter
    private boolean showPreviousButton;

    /**
     * 다음 페이지로 이동 표시 상태
     */
    @Getter
    @Setter
    private boolean showNextButton;

    /**
     * 아이템
     */
    @Getter
    @Setter
    private ArrayList<T> items;
}
