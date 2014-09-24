package cn.abc.test.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * spring 定时任务
 * 
 * @author 郭志斌
 * @version 1.0.0 , 2013年9月23日
 */
@Service
public class JobService {

	private static Logger _logger = LoggerFactory.getLogger(JobService.class);

	private static long last_called =3L; 
	private static final long delay = 100000;
	
	/**
	 * 任务调度方法示例,该方法不能有返回值否则会出现异常
	 * 
	 * 使用 cron 表达式 e.g. <code>@Scheduled(cron="")</code>
	 */
	@Scheduled(fixedDelay = delay)
	public void job() {
		long time_now = System.currentTimeMillis();
		long midle = 0;
		if(last_called==0)
		{
			last_called = time_now;
		}
		else
		{
			midle = time_now - last_called-delay;
			last_called = time_now;
		}
		_logger.debug("任务调度启动,间隔时间 {} 毫秒", midle);
	}

}
