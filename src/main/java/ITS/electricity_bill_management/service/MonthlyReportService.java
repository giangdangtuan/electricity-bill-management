package ITS.electricity_bill_management.service;

import ITS.electricity_bill_management.model.User;
import ITS.electricity_bill_management.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonthlyReportService {

    private static final Logger logger = LoggerFactory.getLogger(MonthlyReportService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmailService emailService;

    @Scheduled(cron = "0 */3 * * * ?")  // Chạy mỗi 3 phút
    public void sendMonthlyBillReports() {
        logger.info("Bắt đầu gửi báo cáo hóa đơn hàng tháng.");

        List<User> users = userRepository.findAll();
        for (User user : users) {
            sendBillReportAsync(user);
        }

        logger.info("Hoàn thành gửi báo cáo hóa đơn hàng tháng.");
    }

    @Async("taskExecutor")
    public void sendBillReportAsync(User user) {
        logger.info("Đang chuẩn bị gửi báo cáo cho người dùng: " + user.getUsername());

        String subject = "Báo cáo hóa đơn tiền điện tháng";
        String body = "<h1>Báo cáo hóa đơn tiền điện</h1>" +
                "<p>Kính gửi " + user.getUsername() + ",</p>" +
                "<p>Đây là báo cáo hóa đơn tiền điện tháng này.</p>";

        // Gửi email báo cáo
        emailService.sendEmail(user.getEmail(), subject, body);
    }
}

