package com.xwray.groupie;

import androidx.annotation.NonNull;

import java.util.Collection;

class GroupUtils {
    static Item getItem(Collection<? extends Group> groups, int position) {
        int previousPosition = 0;

        for (Group group : groups) {
            int size = group.getItemCount();
            if (size + previousPosition > position) {
                return group.getItem(position - previousPosition);
            }
            previousPosition += size;
        }

        throw new IndexOutOfBoundsException("Wanted item at " + position + " but there are only "
                + previousPosition + " items");
    }

    static int getItemCount(@NonNull Collection<? extends Group> groups) {
        int size = 0;
        for (Group group : groups) {
            size += group.getItemCount();
        }
        return size;
    }
}
