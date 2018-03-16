package com.nca.domain.interactors;


import com.nca.domain.executor.PostExecutionThread;
import com.nca.domain.executor.ThreadExecutor;

import java.util.concurrent.Executor;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

public abstract class BaseUseCase {

    // поток в котором будем получать резуцльтаты в presentation слое
    protected Scheduler postExecutionThread;

    // поток в котором будем выполнять все сложные запросы (дургой поток не UI)
    protected Scheduler threadExecution;


    public BaseUseCase(PostExecutionThread postExecutionThread) {
        this.postExecutionThread = postExecutionThread.getScheduler();
        this.threadExecution = Schedulers.io();
    }

    public BaseUseCase(PostExecutionThread postExecutionThread, ThreadExecutor threadExecution) {
        this.postExecutionThread = postExecutionThread.getScheduler();
        this.threadExecution = Schedulers.from(threadExecution);
    }
}
