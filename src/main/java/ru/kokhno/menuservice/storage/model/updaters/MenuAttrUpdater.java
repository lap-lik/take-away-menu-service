package ru.kokhno.menuservice.storage.model.updaters;

import jakarta.persistence.criteria.CriteriaUpdate;
import jakarta.persistence.metamodel.SingularAttribute;
import lombok.AllArgsConstructor;
import ru.kokhno.menuservice.storage.model.MenuItem;

import java.util.function.Function;

@AllArgsConstructor
public class MenuAttrUpdater<V> {
    SingularAttribute<MenuItem, V> attr;
    Function<MenuItem, V> valueExtractor;

    public void updateAttr(CriteriaUpdate<MenuItem> criteria, MenuItem menuItem) {
        V value = valueExtractor.apply(menuItem);
        if (value != null) {
            criteria.set(attr, value);
        }
    }
}
