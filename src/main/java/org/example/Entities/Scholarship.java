package org.example.Entities;

public record Scholarship(int id, String type, int amount)
{
    @Override
    public String toString() {
        return type + " - " + amount;
    }
}