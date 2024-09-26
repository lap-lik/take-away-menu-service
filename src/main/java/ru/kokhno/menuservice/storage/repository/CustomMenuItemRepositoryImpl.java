package ru.kokhno.menuservice.storage.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaUpdate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.kokhno.menuservice.storage.model.MenuItem;
import ru.kokhno.menuservice.storage.model.MenuItem_;
import ru.kokhno.menuservice.storage.model.updaters.MenuAttrUpdater;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CustomMenuItemRepositoryImpl implements CustomMenuItemRepository {

    private final EntityManager em;
    private final List<MenuAttrUpdater<?>> updaters;

    @Override
    public int updateMenu(Long id, MenuItem menuItem) {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaUpdate<MenuItem> criteriaUpdate = cb.createCriteriaUpdate(MenuItem.class);
        Root<MenuItem> root = criteriaUpdate.from(MenuItem.class);
        updaters.forEach(updater -> updater.updateAttr(criteriaUpdate, menuItem));
        criteriaUpdate.where(cb.equal(root.get(MenuItem_.id), id));
        return em.createQuery(criteriaUpdate).executeUpdate();
    }
}
