package mate.academy.internetshop.service;

import mate.academy.internetshop.model.Bucket;

import java.util.List;

public interface BucketService {

    Bucket create(Bucket bucket);

    Bucket get(Long id);

    Bucket update(Bucket bucket);

    void delete(Long id);

    void delete(Bucket bucket);

    Bucket addItem(Long bucketId, Long itemId);

    Bucket clear(Long bucketId);

    List getAllItems(Long bucketId);

}
