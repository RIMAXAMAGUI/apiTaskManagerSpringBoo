package com.mdice.apitaskmanager.mapper;

public interface IMapper <I, O> {
   public O map(I in);
}
