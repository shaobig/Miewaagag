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
			
			//Mother's mother
			Parents randomPersonGrandmotherOneParents = new Parents(null, null);
			parentsRepo.save(randomPersonGrandmotherOneParents);
			
			Name randomPersonGrandmotherOneName = new Name("Victoria", "Oladina");
			FullName randomPersonGrandmotherOneFullName = new FullName(randomPersonGrandmotherOneName, "Filippovna");
			Member randomPersonGrandmotherOne = new Member.Builder(randomPersonGrandmotherOneFullName)
					.setBirthYear(1941)
					.setParents(randomPersonGrandmotherOneParents)
					.setSex(Sex.FEMALE)
					.getMember();
			
			nameRepo.save(randomPersonGrandmotherOneName);
			fullNameRepo.save(randomPersonGrandmotherOneFullName);
			memberRepo.save(randomPersonGrandmotherOne);
			
			//Mother's father
			Parents randomPersonGrandfatherOneParents = new Parents(null, null);
			parentsRepo.save(randomPersonGrandfatherOneParents);
			
			Name randomPersonGrandfatherOneName = new Name("Nikita", "Golenkin");
			FullName randomPersonGrandfatherOneFullName = new FullName(randomPersonGrandfatherOneName, "Pavlovich");
			Member randomPersonGrandfatherOne = new Member.Builder(randomPersonGrandfatherOneFullName)
					.setBirthYear(1944)
					.setParents(randomPersonGrandfatherOneParents)
					.setSex(Sex.MALE)
					.getMember();
			
			nameRepo.save(randomPersonGrandfatherOneName);
			fullNameRepo.save(randomPersonGrandfatherOneFullName);
			memberRepo.save(randomPersonGrandfatherOne);
			
			//Person's mother
			Parents randomPersonMotherParents = new Parents(randomPersonGrandmotherOne, randomPersonGrandfatherOne);
			parentsRepo.save(randomPersonMotherParents);
			
			Name randomPersonMotherName = new Name("Ekaterina", "Golenkina");
			FullName randomPersonMotherFullName = new FullName(randomPersonMotherName, "Nikitichna");
			Member randomPersonMother = new Member.Builder(randomPersonMotherFullName)
					.setBirthYear(1977)
					.setParents(randomPersonMotherParents)
					.setSex(Sex.FEMALE)
					.getMember();
			
			nameRepo.save(randomPersonMotherName);
			fullNameRepo.save(randomPersonMotherFullName);
			memberRepo.save(randomPersonMother);
			
			//Father's mother
			Parents randomPersonGrandmotherTwoParents = new Parents(null, null);
			parentsRepo.save(randomPersonGrandmotherTwoParents);
			
			Name randomPersonGrandmotherTwoName = new Name("Anna", "Brehina");
			FullName randomPersonGrandmotherTwoFullName = new FullName(randomPersonGrandmotherTwoName, "Alexeevna");
			Member randomPersonGrandmotherTwo = new Member.Builder(randomPersonGrandmotherTwoFullName)
					.setBirthYear(1958)
					.setParents(randomPersonGrandmotherTwoParents)
					.setSex(Sex.FEMALE)
					.getMember();
			
			nameRepo.save(randomPersonGrandmotherTwoName);
			fullNameRepo.save(randomPersonGrandmotherTwoFullName);
			memberRepo.save(randomPersonGrandmotherTwo);
			
			//Father's father
			Parents randomPersonGrandfatherTwoParents = new Parents(null, null);
			parentsRepo.save(randomPersonGrandfatherTwoParents);
			
			Name randomPersonGrandfatherTwoName = new Name("Stanislav", "Arendt");
			FullName randomPersonGrandfatherTwoFullName = new FullName(randomPersonGrandfatherTwoName, "Glebovich");
			Member randomPersonGrandfatherTwo = new Member.Builder(randomPersonGrandfatherTwoFullName)
					.setBirthYear(1953)
					.setParents(randomPersonGrandfatherTwoParents)
					.setSex(Sex.MALE)
					.getMember();
			
			nameRepo.save(randomPersonGrandfatherTwoName);
			fullNameRepo.save(randomPersonGrandfatherTwoFullName);
			memberRepo.save(randomPersonGrandfatherTwo);
			
			//Person's father
			Parents randomPersonFatherParents = new Parents(randomPersonGrandmotherTwo, randomPersonGrandfatherTwo);
			parentsRepo.save(randomPersonFatherParents);
			
			Name randomPersonFatherName = new Name("Rostislav", "Arendt");
			FullName randomPersonFatherFullName = new FullName(randomPersonFatherName, "Stanislavovich");
			Member randomPersonFather = new Member.Builder(randomPersonFatherFullName)
					.setBirthYear(1982)
					.setParents(randomPersonFatherParents)
					.setSex(Sex.MALE)
					.getMember();
			
			nameRepo.save(randomPersonFatherName);
			fullNameRepo.save(randomPersonFatherFullName);
			memberRepo.save(randomPersonFather);
			
			//Person's sister
			Parents randomPersonSisterParents = new Parents(randomPersonMother, randomPersonFather);
			parentsRepo.save(randomPersonSisterParents);
			
			Name randomPersonSisterName = new Name("Irina", "Arendt");
			FullName randomPersonSisterFullName = new FullName(randomPersonSisterName, "Rostislavovna");
			Member randomPersonSister = new Member.Builder(randomPersonSisterFullName)
					.setBirthYear(2006)
					.setParents(randomPersonSisterParents)
					.setSex(Sex.FEMALE)
					.getMember();
			
			nameRepo.save(randomPersonSisterName);
			fullNameRepo.save(randomPersonSisterFullName);
			memberRepo.save(randomPersonSister);
			
			//Random person
			Parents randomPersonParents = randomPersonSisterParents;
			
			Name randomPersonName = new Name("Timofey", "Arendt");
			FullName randomPersonFullName = new FullName(randomPersonName, "Rostislavovich");
			Member randomPerson = new Member.Builder(randomPersonFullName)
					.setBirthYear(2014)
					.setParents(randomPersonParents)
					.setSex(Sex.MALE)
					.getMember();
			
			nameRepo.save(randomPersonName);
			fullNameRepo.save(randomPersonFullName);
			memberRepo.save(randomPerson);
			
			//Fresco's mother
			Parents memberOneMotherParents = new Parents(null, null);
			parentsRepo.save(memberOneMotherParents);
			
			Name frescoMotherName = new Name("Elena", "Fresco");
			FullName frescoMotherFullName = new FullName(frescoMotherName);
			Member frescoMother = new Member.Builder(frescoMotherFullName)
					.setBirthYear(1989)
					.setParents(memberOneMotherParents)
					.setSex(Sex.FEMALE)
					.getMember();
			
			nameRepo.save(frescoMotherName);
			fullNameRepo.save(frescoMotherFullName);
			memberRepo.save(frescoMother);
			
			//Fresco's father
			Parents frescoFatherParents = new Parents(null, null);
			parentsRepo.save(frescoFatherParents);
			
			Name frescoFatherName = new Name("Isaac", "Fresco");
			FullName frescoFatherFullName = new FullName(frescoFatherName);
			Member frescoFather = new Member.Builder(frescoFatherFullName)
					.setBirthYear(1991)
					.setParents(frescoFatherParents)
					.setSex(Sex.MALE)
					.getMember();
			
			nameRepo.save(frescoFatherName);
			fullNameRepo.save(frescoFatherFullName);
			memberRepo.save(frescoFather);
			
			//Fresco himself
			Parents frescoParents = new Parents(frescoMother, frescoFather);
			parentsRepo.save(frescoParents);
					
			Name frescoName = new Name("Jack", "Fresco");
			FullName frescoFullName = new FullName(frescoName, "Isaacovich");
			Member fresco = new Member.Builder(frescoFullName)
					.setBirthYear(2016)
					.setParents(frescoParents)
					.setSex(Sex.MALE)
					.getMember();

			nameRepo.save(frescoName);
			fullNameRepo.save(frescoFullName);
			memberRepo.save(fresco);
		};
	}
}