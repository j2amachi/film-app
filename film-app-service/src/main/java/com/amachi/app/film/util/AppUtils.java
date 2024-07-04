package com.amachi.app.film.util;

import io.swagger.v3.oas.annotations.Hidden;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Sort;

public abstract class AppUtils {

    private AppUtils() {
    }

    @Hidden
    public static Sort getSort(String sort, String defaultSort) {
        Sort sorting = Sort.by(AppConstants.DEFAULT_SORT_DIRECTION, defaultSort);
        if (StringUtils.isNotEmpty(sort)) {
            sorting = Sort.by(AppConstants.DEFAULT_SORT_DIRECTION, sort);
        }
        return sorting;
    }
}