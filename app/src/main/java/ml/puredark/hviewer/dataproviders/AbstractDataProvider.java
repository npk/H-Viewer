
package ml.puredark.hviewer.dataproviders;

import java.util.Collection;
import java.util.List;

public abstract class AbstractDataProvider {

    public static abstract class Data {
        public abstract int getId();
    }

    public abstract int getCount();

    public abstract List getItems();

    public abstract Data getItem(int index);

    public abstract void removeItem(int position);

    public abstract void clear();

    public abstract void addItem(Data item);

    public abstract void addItem(int position, Data item);

    public abstract void addAll(Collection items);
}
