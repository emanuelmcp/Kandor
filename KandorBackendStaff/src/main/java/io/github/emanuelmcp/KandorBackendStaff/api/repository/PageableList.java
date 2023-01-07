package io.github.emanuelmcp.KandorBackendStaff.api.repository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class PageableList<T> {
    long count;
    int from;
    int to;
    List<T> items;
}
