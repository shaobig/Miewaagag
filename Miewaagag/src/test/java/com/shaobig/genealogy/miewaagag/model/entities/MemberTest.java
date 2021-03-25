package com.shaobig.genealogy.miewaagag.model.entities;

import static org.junit.Assert.assertNotEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import com.shaobig.genealogy.miewaagag.model.entities.name.FullName;
import com.shaobig.genealogy.miewaagag.model.entities.name.Name;
import com.shaobig.genealogy.miewaagag.model.entities.sex.Sex;

public class MemberTest {
	
	private static Member member;

	@BeforeClass
	public static void setUp() throws Exception {
		Name motherName = new Name("Ivana", "Lavatalova");
		FullName motherFullName = new FullName(motherName, "Antonovna");
		Member mother = new Member.Builder(motherFullName)
				.setSex(Sex.FEMALE)
				.getMember();
		
		Name fatherName = new Name("Sergey", "Pupovinov");
		FullName fatherFullName = new FullName(fatherName, "Sergeevich");
		Member father = new Member.Builder(fatherFullName)
				.setSex(Sex.MALE)
				.getMember();
		
		Parents parents = new Parents(mother, father);
		
		Name name = new Name("Vasiliy", "Pupovinov");
		FullName fullName = new FullName(name, "Sergeevich");
		
		member = new Member.Builder(fullName)
				.setBirthYear(1999)
				.setParents(parents)
				.setSex(Sex.MALE)
				.getMember();
	}

	@Test
	public void testMemberHasParents() {
		assertNotEquals(member.getParents(), null);
	}
	
	@Test
	public void testMemberHasMother() {
		assertNotEquals(member.getParents().getMother(), null);
	}
	
	@Test
	public void testMemberHasFather() {
		assertNotEquals(member.getParents().getFather(), null);
	}

}
