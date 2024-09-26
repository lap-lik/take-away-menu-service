package ru.kokhno.menuservice.storage.repository;

import ru.kokhno.menuservice.storage.model.MenuItem;

public interface CustomMenuItemRepository {

    int updateMenu(Long id, MenuItem menuItem);

}
