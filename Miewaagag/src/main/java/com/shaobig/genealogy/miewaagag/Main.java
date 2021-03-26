package com.shaobig.genealogy.miewaagag;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.shaobig.genealogy.miewaagag.model.entities.Member;
import com.shaobig.genealogy.miewaagag.model.entities.Parents;
import com.shaobig.genealogy.miewaagag.model.entities.name.FullName;
import com.shaobig.genealogy.miewaagag.model.entities.name.Name;
import com.shaobig.genealogy.miewaagag.model.entities.sex.Sex;
import com.shaobig.genealogy.miewaagag.model.repository.FullNameRepository;
import com.shaobig.genealogy.miewaagag.model.repository.MemberRepository;
import com.shaobig.genealogy.miewaagag.model.repository.NameRepository;
import com.shaobig.genealogy.miewaagag.model.repository.ParentsRepository;

@SpringBootApplication
@ComponentScan(basePackages = {"com.shaobig.genealogy.miewaagag"})
public class Main {
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}
	
	@Bean
	private static CommandLineRunner commandLineRunner(
			NameRepository nameRepo,
			FullNameRepository fullNameRepo,
			ParentsRepository parentsRepo,
			MemberRepository memberRepo
			) {
		return args -> {
			
			//First member's mother
			Parents memberOneMotherParents = new Parents(null, null);
			parentsRepo.save(memberOneMotherParents);
			
			Name memberOneMotherName = new Name("Elena", "Fresco");
			FullName memberOneMotherFullName = new FullName(memberOneMotherName);
			Member memberOneMother = new Member.Builder(memberOneMotherFullName)
					.setBirthYear(1989)
					.setParents(memberOneMotherParents)
					.setSex(Sex.FEMALE)
					.getMember();
			
			nameRepo.save(memberOneMotherName);
			fullNameRepo.save(memberOneMotherFullName);
			memberRepo.save(memberOneMother);
			
			//First member's father
			Parents memberOneFatherParents = new Parents(null, null);
			parentsRepo.save(memberOneFatherParents);
			
			Name memberOneFatherName = new Name("Isaac", "Fresco");
			FullName memberOneFatherFullName = new FullName(memberOneFatherName);
			Member memberOneFather = new Member.Builder(memberOneFatherFullName)
					.setBirthYear(1991)
					.setParents(memberOneFatherParents)
					.setSex(Sex.MALE)
					.getMember();
			
			nameRepo.save(memberOneFatherName);
			fullNameRepo.save(memberOneFatherFullName);
			memberRepo.save(memberOneFather);
			
			//Member himself
			Parents memberOneParents = new Parents(memberOneMother, memberOneFather);
			parentsRepo.save(memberOneParents);
					
			Name memberOneName = new Name("Jack", "Fresco");
			FullName memberOneFullName = new FullName(memberOneName, "Isaacovich");
			Member memberOne = new Member.Builder(memberOneFullName)
					.setBirthYear(2016)
					.setParents(memberOneParents)
					.setSex(Sex.MALE)
					.getMember();

			nameRepo.save(memberOneName);
			fullNameRepo.save(memberOneFullName);
			memberRepo.save(memberOne);
		};
	}
}