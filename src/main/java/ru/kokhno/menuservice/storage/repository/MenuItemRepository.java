package ru.kokhno.menuservice.storage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kokhno.menuservice.storage.model.MenuItem;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long>, CustomMenuItemRepository {
}
