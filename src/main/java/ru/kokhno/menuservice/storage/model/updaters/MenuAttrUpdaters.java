package ru.kokhno.menuservice.storage.model.updaters;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.kokhno.menuservice.storage.model.MenuItem_;
import ru.kokhno.menuservice.storage.model.MenuItem;

import java.math.BigDecimal;

@Configuration
public class MenuAttrUpdaters {
    @Bean
    MenuAttrUpdater<String> description() {
        return new MenuAttrUpdater<>(MenuItem_.description, MenuItem::getDescription);
    }

    @Bean
    MenuAttrUpdater<String> imageUrl() {
        return new MenuAttrUpdater<>(MenuItem_.imageUrl, MenuItem::getImageUrl);
    }

    @Bean
    MenuAttrUpdater<String> name() {
        return new MenuAttrUpdater<>(MenuItem_.name, MenuItem::getName);
    }

    @Bean
    MenuAttrUpdater<BigDecimal> price() {
        return new MenuAttrUpdater<>(MenuItem_.price, MenuItem::getPrice);
    }

    @Bean
    MenuAttrUpdater<Long> timeToCook() {
        return new MenuAttrUpdater<>(MenuItem_.timeToCook, MenuItem::getTimeToCook);
    }
}