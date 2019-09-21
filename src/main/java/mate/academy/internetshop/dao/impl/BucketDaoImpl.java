package mate.academy.internetshop.dao.impl;

import mate.academy.internetshop.dao.BucketDao;
import mate.academy.internetshop.dao.Storage;
import mate.academy.internetshop.model.Bucket;

import java.util.NoSuchElementException;

public class BucketDaoImpl implements BucketDao {

    @Override
    public Bucket create(Bucket bucket) {
        Storage.buckets.add(bucket);
        return bucket;
    }

    @Override
    public Bucket get(Long bucketId) {
        return Storage.buckets
                .stream()
                .filter(b -> b.getId().equals(bucketId))
                .findFirst()
                .orElseThrow(() ->
                        new NoSuchElementException("Can't find bucket with id " + bucketId));
    }

    @Override
    public Bucket update(Bucket bucket) {
        for (int i = 0; i < Storage.buckets.size(); i++) {
            if (Storage.buckets.get(i).equals(bucket)) {
                Storage.buckets.set(i, bucket);
                return bucket;
            }
        }
        throw new NoSuchElementException();
    }

    @Override
    public void delete(Long id) {
        Storage.buckets.removeIf(item -> item.getId().equals(id));
    }

    @Override
    public void delete(Bucket bucket) {
        Storage.orders.removeIf(elem -> elem.equals(bucket));
    }
}
