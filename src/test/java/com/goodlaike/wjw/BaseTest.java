package com.goodlaike.wjw;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * 测试基类
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class},webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext
@Transactional
@Rollback
public abstract class BaseTest {}
