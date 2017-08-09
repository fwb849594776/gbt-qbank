package com.fitt.gbt.qbank.repository;

import com.fitt.gbt.qbank.domain.Message;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * <p>@Description: com.fitt.gbt.qbank.repository</p>
 * <p>@Copyright: Copyright(C) 2017 by AIRAG</p>
 * <p>@Author: Chuck[ZhengCongChun]</p>
 * <p>@Created: 2017-08-04</p>
 * <p>@version: 1.0</p>
 */
@Repository
public interface MessageRepository extends MongoRepository<Message, String> {
}
