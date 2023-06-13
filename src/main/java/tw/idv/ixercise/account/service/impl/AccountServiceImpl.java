package tw.idv.ixercise.account.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tw.idv.ixercise.account.dao.AccountRepository;
import tw.idv.ixercise.account.dao.CoachSkillRepository;
import tw.idv.ixercise.account.entity.*;
import tw.idv.ixercise.account.service.AccountService;
import tw.idv.ixercise.core.Core;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Properties;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository repo;

    @Autowired
    private CoachSkillRepository csrepo;


    // 新增會員===============================================================
    @Override
    @Transactional
    public Account signUp(Account account) {
//        撰寫商業邏輯，判斷送入的會員資料是否合乎規定
        if (repo.findByAccountPhone(account.getAccountPhone()) != null) {
            account.setMessage("此手機被註冊過");
            account.setSuccessful(false);
            return account;
        }

        account.setAccountLevel(1);
        account.setAccountState(1);
        account.setAccountVerify(genAuthCode());
        account.setAccountReport(0);
        account.setAccountCreatetime(new Timestamp(System.currentTimeMillis()));
        account.setAccountUpdatetime(new Timestamp(System.currentTimeMillis()));
//        System.out.println(account);
//        System.out.println("==================");
        account = repo.save(account);
//        System.out.println(account);
        account.setMessage("註冊成功");
        account.setSuccessful(true);
        return account;
    }

    //    新增管理員
    @Override
    @Transactional
    public Core addAdmin(Account account) {
        if (repo.findByAccountEmail(account.getAccountEmail()) != null) {
            return new Core(false, "此信箱已被使用");
        }
        int ran = (int) (Math.random() * 99999999);
        System.out.println(ran);
        account.setAccountPhone("09" + ran);
        account.setAccountAddress("管理員專用");
        account.setAccountLevel(3);
        account.setAccountState(1);
        account.setAccountVerify(genAuthCode());
        account.setAccountReport(0);
        account.setAccountCreatetime(new Timestamp(System.currentTimeMillis()));
        account.setAccountUpdatetime(new Timestamp(System.currentTimeMillis()));
        account.setAccountNickname("管理員");
        account.setAccountBirthday(new Date(0));
        account.setAccountGender(0);
        account.setAccountIntro("管理員");

        repo.save(account);
        return new Core(true, "新增成功");
    }

    //產生驗證碼=================================================
    public String genAuthCode() {
        String x = new String();
        while (true) {
            int ran = (int) (Math.random() * 3);
            switch (ran) {
                case 0:
                    int i1 = (int) (Math.random() * 10 + 48);
                    x += (char) i1;
                    break;
                case 1:
                    int i2 = (int) (Math.random() * 26 + 65);
                    x += (char) i2;
                    break;
                case 2:
                    int i3 = (int) (Math.random() * 26 + 97);
                    x += (char) i3;
                    break;
            }
            if (x.length() == 8) {
                break;
            }
        }
        return x+"1";
    }

    // 查詢登入=============================================================
    @Override
    public Account login(Account account) {
        final String accountPhone = account.getAccountPhone();
        final String accountPassword = account.getAccountPassword();

        if (accountPhone == null) {
            account.setMessage("電話未輸入");
            account.setSuccessful(false);
            return account;
        }
        if (accountPassword == null) {
            account.setMessage("密碼未輸入");
            account.setSuccessful(false);
            return account;
        }
        account = repo.findForLogin(accountPhone, accountPassword);
        if (account == null) {
            account = new Account();
            account.setMessage("帳號或密碼錯誤");
            account.setSuccessful(false);
            return account;
        }
        if(account.getAccountState() == 0){
            account = new Account();
            account.setMessage("帳號已停權");
            account.setSuccessful(false);
            return account;
        }

        account.setMessage("登入成功");
        account.setSuccessful(true);
        return account;
    }

    @Override
    public Account loginForAd(Account account) {
        final String accountEmail = account.getAccountEmail();
        final String accountPassword = account.getAccountPassword();

        if (accountEmail == null) {
            account.setMessage("信箱未輸入");
            account.setSuccessful(false);
            return account;
        }
        if (accountPassword == null) {
            account.setMessage("密碼未輸入");
            account.setSuccessful(false);
            return account;
        }
        account = repo.findForAdLogin(accountEmail, accountPassword);
        if (account == null) {
            account = new Account();
            account.setMessage("帳號或密碼錯誤");
            account.setSuccessful(false);
            return account;
        }
        if(account.getAccountLevel() != 3){
            account = new Account();
            account.setMessage("登入錯誤");
            account.setSuccessful(false);
            return account;
        }
        if(account.getAccountState() == 0){
            account = new Account();
            account.setMessage("帳號已停權");
            account.setSuccessful(false);
            return account;
        }

        account.setMessage("登入成功");
        account.setSuccessful(true);
        return account;
    }

    //透過ID更新會員資料==================================================
    @Transactional
    @Override
    public Account updateById(Account account) {
//        找資料庫裡的舊會員資料
        Account oAccount = repo.findByAccountId(account.getAccountId());
        String newPassword = account.getAccountPassword();
        if (newPassword == null || newPassword.isEmpty()) {
            account.setAccountPassword(oAccount.getAccountPassword());
        }

        account.setAccountId(oAccount.getAccountId());
        account.setAccountPhone(oAccount.getAccountPhone());
        account.setAccountLevel(oAccount.getAccountLevel());
        account.setAccountState(oAccount.getAccountState());
        account.setAccountId(oAccount.getAccountId());
        account.setAccountBirthday(oAccount.getAccountBirthday());
        account.setAccountCreatetime(oAccount.getAccountCreatetime());
        account.setAccountUpdatetime(new Timestamp(System.currentTimeMillis()));
        account.setAccountGender(oAccount.getAccountGender());
        account.setAccountReport(oAccount.getAccountReport());
        account.setAccountVerify(oAccount.getAccountVerify());

//      怎麼判斷修改成功與否?
        account = repo.save(account);
        account.setMessage("修改成功");
        account.setSuccessful(true);
        return account;

    }

    public Boolean remove(Integer AccountId) {
        repo.deleteById(AccountId);
        return !(repo.existsById(AccountId));
    }

    @Override
    public Account save(Account account) {
        return repo.save(account);
    }

    public List<Account> findAll() {
        return repo.findAll();
    }

    @Override
    public List<LessAccount> findAllLessInfo() {
        List<Account> acclist = repo.findAllForUser();
        List<LessAccount> lAacc = new ArrayList<>();
        for (Account acc : acclist) {
            LessAccount la = new LessAccount(acc);
            lAacc.add(la);
        }

        return lAacc;
    }

    @Override
    public List<CourseAccount> findAllCourseInfo() {
        List<Account> acclist = repo.findAll();
        List<CourseAccount> lAacc = new ArrayList<>();
        for (Account acc : acclist) {
            CourseAccount la = new CourseAccount(acc);
            lAacc.add(la);
        }
        return lAacc;
    }


    //    後台用=======================================================================
    @Override
    public List<LessAccount> findAllLessInfoAdmin() {
        List<Account> acclist = repo.findAllForAdmin();
        List<LessAccount> lAacc = new ArrayList<>();
        for (Account acc : acclist) {
            LessAccount la = new LessAccount(acc);
            lAacc.add(la);
        }
        return lAacc;
    }

    @Override
    public List<SkillManageDTO> findAllSkill() {
        List<CoachSkill> csli = csrepo.findAllSkillForAd();

//        if (csli == null) {
//            CoachSkill cs = new CoachSkill();
//            cs.setSuccessful(false);
//            cs.setMessage("查無資料");
//            csli.add(cs);
//        }
        List<SkillManageDTO> skm = new ArrayList<>();
        for (CoachSkill cs : csli) {
            SkillManageDTO sk = new SkillManageDTO(cs, repo.findAccountNameByAccountId(cs.getAccountId()));
            skm.add(sk);
        }
        return skm;
    }

    @Override
    public Account findById(Integer AccountId) {
        return repo.findByAccountId(AccountId);
    }

    @Override
    public Core modifyacc(Account account) {
        Account acc = repo.findByAccountId(account.getAccountId());
        acc.setAccountLevel(account.getAccountLevel());
        acc.setAccountState(account.getAccountState());
        repo.save(acc);
        Core core = new Core();
        core.setMessage("修改成功");
        core.setSuccessful(true);
        return core;
    }

    @Override
    public PgAccount findForPg(Integer accountId) {
        Account acc = repo.findByAccountId(accountId);
        int level = acc.getAccountLevel();

        if (level == 1) {
            acc.setSuccessful(true);
            acc.setMessage("查詢成功-會員");
            return new PgAccount(acc);
        } else if (level == 2) {
            acc.setSuccessful(true);
            acc.setMessage("查詢成功-教練");
            List<CoachSkill> beforecheckli = csrepo.findAllByAccountId(accountId);
            List<CoachSkill> csli = beforecheckli.stream().filter(coachSkill -> coachSkill.getSkillState() == 1).collect(Collectors.toList());
            return new PgAccount(acc, csli);
        } else {
            return new PgAccount(false, "查詢錯誤");
        }
    }

    @Override
    public CoachSkill findSkById(Integer skillId) {
        CoachSkill cs = csrepo.findById(skillId).orElse(new CoachSkill(false, "查無此申請"));
        return cs;
    }

    @Override
    public Core modifySkillApply(CoachSkill coachSkill) {
       CoachSkill cs = csrepo.findById(coachSkill.getSkillId()).orElse(new CoachSkill(false,"查詢不到此筆申請"));
       if(Objects.equals(cs.getSkillState(),coachSkill.getSkillState())){
           return new Core(false,"請調整狀態後再送出");
       }

       cs.setSkillState(coachSkill.getSkillState());
       CoachSkill ncs = csrepo.save(cs);
       if(ncs == null){
           return new Core(false,"修改失敗");
       }
       Account acc = repo.findByAccountId(ncs.getAccountId());

       if(acc.getAccountLevel() == 1){
           acc.setAccountLevel(2);
           repo.save(acc);
       }
       return new Core(true,"修改成功");
    }


    //    寄Email========================================================
    @Override
    @Transactional
    public Core VerifyEmail(String accountEmail) {
        Account account = repo.findByAccountEmail(accountEmail);
        boolean s = sendVerifymail(account.getAccountEmail(), account.getAccountNickname(), account.getAccountVerify());

        Core core;
        if (s) {
            core = new Core(s, "寄送成功");
        } else {
            core = new Core(false, "寄送失敗");
        }
        return core;
    }

    @Override
    public Core InputVerify(Account account) {
        Account acc = repo.findByAccountEmail(account.getAccountEmail());
        if (Objects.equals(acc.getAccountVerify(), account.getAccountVerify())) {
            acc.setAccountVerify(genAuthCode());
            repo.save(acc);
            return new Core(true, "驗證成功");
        } else {
            return new Core(false, "驗證失敗");
        }
    }

    public boolean sendVerifymail(String accountEmail, String accountNickname, String accountVerify) {

        String to = accountEmail;

        String subject = "驗證碼通知";

        String ch_name = accountNickname;
        String passRandom = accountVerify;
        String messageText = "Hello! " + ch_name + " 此為您的驗證碼: " + passRandom + "\n" + "請回到頁面上輸入";


        return sendMail(to, subject, messageText);


    }

    public boolean sendForgetPassword(String accountEmail, String accountNickname, String accountPassword) {

        String to = accountEmail;

        String subject = "密碼通知";

        String ch_name = accountNickname;
        String passRandom = accountPassword;
        String messageText = "Hello! " + ch_name + " 臨時密碼為: " + passRandom + "\n" + "請登入後修改密碼";


        return sendMail(to, subject, messageText);


    }

    public boolean sendMail(String to, String subject, String messageText) {

        try {
            // 設定使用SSL連線至 Gmail smtp Server
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");

            // ●設定 gmail 的帳號 & 密碼 (將藉由你的Gmail來傳送Email)
            // ●1) 登入你的Gmail的:
            // ●2) 點選【管理你的 Google 帳戶】
            // ●3) 點選左側的【安全性】

            // ●4) 完成【兩步驟驗證】的所有要求如下:
            //     ●4-1) (請自行依照步驟要求操作之.....)

            // ●5) 完成【應用程式密碼】的所有要求如下:
            //     ●5-1) 下拉式選單【選取應用程式】--> 選取【郵件】
            //     ●5-2) 下拉式選單【選取裝置】--> 選取【Windows 電腦】
            //     ●5-3) 最後按【產生】密碼
            final String myGmail = "bullhead01@gmail.com";
            final String myGmail_password = "smzmwjfrudswaujq";
            Session session = Session.getInstance(props, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(myGmail, myGmail_password);
                }
            });

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myGmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

            //設定信中的主旨
            message.setSubject(subject);
            //設定信中的內容
            message.setText(messageText);

            Transport.send(message);
            return true;
        } catch (MessagingException e) {

            e.printStackTrace();
            return false;
        }
    }

    @Override
    @Transactional
    public Core forgetPassword(Account account) {
        Account oAcc = repo.findByAccountEmail(account.getAccountEmail());
        Account acc = repo.findByAccountEmail(account.getAccountEmail());
        if (acc == null) {
            return new Core(false, "查無此信箱");
        }
        acc.setAccountPassword(acc.getAccountVerify());
        boolean s = sendForgetPassword(acc.getAccountEmail(), acc.getAccountNickname(), acc.getAccountPassword());
        if (s) {
            acc.setAccountVerify(genAuthCode());
            repo.save(acc);
        } else {
            repo.save(oAcc);
            return new Core(false, "無法寄出，請洽管理員");
        }
        return new Core(true, "臨時密碼已寄出，請至信箱確認");
    }

//   for shop ==============================================================
public Account searchforshop(String accountPhone,String accountPassword){
        return repo.findForLogin(accountPhone,accountPassword);
}




}
