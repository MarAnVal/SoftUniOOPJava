package main.java.Exam_15_August_2021.Restaurant.repositories;

import main.java.Exam_15_August_2021.Restaurant.entities.tables.interfaces.Table;
import main.java.Exam_15_August_2021.Restaurant.repositories.interfaces.TableRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class TableRepositoryImpl implements TableRepository<Table> {
    private Collection<Table> tables;

    public TableRepositoryImpl() {
        this.tables = new ArrayList<>();
    }

    @Override
    public Collection<Table> getAllEntities() {
        return Collections.unmodifiableCollection(this.tables);
    }

    @Override
    public void add(Table table) {
        this.tables.add(table);
    }

    @Override
    public Table byNumber(int number) {
        for (Table table : tables) {
            if (table.getTableNumber() == number) {
                return table;
            }
        }
        return null;
    }
}
