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
			Name memberOneMotherName = new Name("Marina", "Kupchuk");
			FullName memberOneMotherFullName = new FullName(memberOneMotherName);
			Member memberOneMother = new Member.Builder(memberOneMotherFullName)
					.setBirthYear(1980)
					.setSex(Sex.FEMALE)
					.getMember();
			
			nameRepo.save(memberOneMotherName);
			fullNameRepo.save(memberOneMotherFullName);
			memberRepo.save(memberOneMother);
			
			Name memberOneFatherName = new Name("Ivan", "Bubkin");
			FullName memberOneFatherFullName = new FullName(memberOneFatherName);
			Member memberOneFather = new Member.Builder(memberOneFatherFullName)
					.setBirthYear(1974)
					.setSex(Sex.FEMALE)
					.getMember();
			
			nameRepo.save(memberOneFatherName);
			fullNameRepo.save(memberOneFatherFullName);
			memberRepo.save(memberOneFather);
			
			Parents memberOneParents = new Parents(memberOneMother, memberOneFather);
			parentsRepo.save(memberOneParents);
					
			Name memberOneName = new Name("Alexander", "Bubkin");
			FullName memberOneFullName = new FullName(memberOneName);
			Member memberOne = new Member.Builder(memberOneFullName)
					.setBirthYear(2003)
					.setParents(memberOneParents)
					.setSex(Sex.MALE)
					.getMember();
			
			nameRepo.save(memberOneName);
			fullNameRepo.save(memberOneFullName);
			memberRepo.save(memberOne);
		};
	}
}