package com.levelup.levelup_portal.config;

import com.levelup.levelup_portal.entity.*;
import com.levelup.levelup_portal.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;

@Configuration
public class DataSeeder {

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepo,
                                   SkillRepository skillRepo,
                                   QuestRepository questRepo,
                                   InternshipRepository internshipRepo,
                                   ApplicationRepository applicationRepo,
                                   PasswordEncoder passwordEncoder) {
        return args -> {

            // 1️⃣ Users with encoded password
            User bhanu = new User();
            bhanu.setName("Bhanu Prasad");
            bhanu.setEmail("bhanu@example.com");
            bhanu.setPassword(passwordEncoder.encode("password")); // ✅ encode
            bhanu.setRole("ROLE_USER");
            userRepo.save(bhanu);

            User arya = new User();
            arya.setName("Arya Stark");
            arya.setEmail("arya@example.com");
            arya.setPassword(passwordEncoder.encode("password")); // ✅ encode
            arya.setRole("ROLE_USER");
            userRepo.save(arya);

            // 2️⃣ Skills
            Skill physical = new Skill();
            physical.setType("Physical");
            physical.setUser(bhanu);
            skillRepo.save(physical);

            Skill financial = new Skill();
            financial.setType("Financial");
            financial.setUser(bhanu);
            skillRepo.save(financial);

            Skill technical = new Skill();
            technical.setType("Technical");
            technical.setUser(bhanu);
            skillRepo.save(technical);

            // Arya's skills
            Skill physical2 = new Skill();
            physical2.setType("Physical");
            physical2.setUser(arya);
            skillRepo.save(physical2);

            Skill technical2 = new Skill();
            technical2.setType("Technical");
            technical2.setUser(arya);
            skillRepo.save(technical2);

            // 3️⃣ Quests
            Quest quest1 = new Quest();
            quest1.setTitle("Pushups 50 reps");
            quest1.setDescription("Complete 50 pushups in one set");
            quest1.setType("Main");
            quest1.setStatus("OPEN");
            quest1.setRewardXP(100);
            quest1.setDeadline(LocalDateTime.now().plusDays(7));
            quest1.setUser(bhanu);
            quest1.setSkill(physical);
            questRepo.save(quest1);

            Quest quest2 = new Quest();
            quest2.setTitle("Swing Trade Profit ₹1L");
            quest2.setDescription("Make ₹1L profit from a swing trade");
            quest2.setType("Main");
            quest2.setStatus("OPEN");
            quest2.setRewardXP(300);
            quest2.setDeadline(LocalDateTime.now().plusDays(14));
            quest2.setUser(bhanu);
            quest2.setSkill(financial);
            questRepo.save(quest2);

            Quest quest3 = new Quest();
            quest3.setTitle("Build REST API");
            quest3.setDescription("Create a simple Java Spring Boot REST API");
            quest3.setType("Side");
            quest3.setStatus("OPEN");
            quest3.setRewardXP(200);
            quest3.setDeadline(LocalDateTime.now().plusDays(10));
            quest3.setUser(bhanu);
            quest3.setSkill(technical);
            questRepo.save(quest3);

            System.out.println("✅ Sample data seeded successfully!");
        };
    }
}
