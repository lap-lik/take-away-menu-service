package ru.kokhno.menuservice.storage.repository;

import ru.kokhno.menuservice.dto.UpdateMenuRequest;

public interface CustomMenuItemRepository {

    int updateMenu(Long id, UpdateMenuRequest updateDto);

}
