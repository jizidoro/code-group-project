package com.company.app.config;

import com.company.app.core.bases.UseCase;
import com.company.app.core.bases.UseCaseManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class SpringUseCaseManager implements UseCaseManager, BeanFactoryAware {
    private static final Logger LOGGER = LoggerFactory.getLogger(SpringUseCaseManager.class);

    private AutowireCapableBeanFactory beanFactory;

    @Autowired
    public SpringUseCaseManager() {
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = (AutowireCapableBeanFactory) beanFactory;
    }


    @Override
    public void prepare(UseCase usecase) {
        beanFactory.autowireBean(usecase);
    }

    @Override
    public void complete(UseCase usecase) {
    }

    @Override
    public void destroy(UseCase usecase) {
        try {
            beanFactory.destroyBean(usecase);
        } catch (Exception e) {
            LOGGER.warn("Falha ao destruir usecase: " + usecase.getClass().getName(), e);
        }
    }
}
