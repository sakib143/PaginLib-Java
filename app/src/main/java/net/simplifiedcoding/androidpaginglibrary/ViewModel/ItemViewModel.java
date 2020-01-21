package net.simplifiedcoding.androidpaginglibrary.ViewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.paging.LivePagedListBuilder;
import android.arch.paging.PageKeyedDataSource;
import android.arch.paging.PagedList;

import net.simplifiedcoding.androidpaginglibrary.PagingLib.ItemDataSource;
import net.simplifiedcoding.androidpaginglibrary.PagingLib.ItemDataSourceFactory;
import net.simplifiedcoding.androidpaginglibrary.Model.Item;


public class ItemViewModel extends ViewModel {

    public LiveData<PagedList<Item>> itemPagedList;
    private LiveData<PageKeyedDataSource<Integer, Item>> liveDataSource;
    private ItemDataSourceFactory itemDataSourceFactory;
    private PagedList.Config config;

    public ItemViewModel() {
        itemDataSourceFactory = new ItemDataSourceFactory();
        liveDataSource = itemDataSourceFactory.getItemLiveDataSource();
        config = (new PagedList.Config.Builder())
                .setEnablePlaceholders(false)
                .setPageSize(ItemDataSource.PAGE_SIZE)
                .build();
        itemPagedList = (new LivePagedListBuilder(itemDataSourceFactory, config)).build();
    }
}
