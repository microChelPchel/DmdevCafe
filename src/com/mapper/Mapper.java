package com.mapper;

public interface Mapper<F,T> {

    T map(F from);

}
