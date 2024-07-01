package com.estate.back.repository.resultSet;

public interface GetLocalDataResultSet 
{
    String getYearMonth();
    Integer getSale();
    Integer getLease();
    Integer getMonthRent();
}

//`year_month` as yearMonth, 
// sale, 
// lease, 
// month_rent as monthRent
//!!!복습완료