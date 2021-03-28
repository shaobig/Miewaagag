package com.shaobig.genealogy.miewaagag.model.entities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

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
	public void testSetId() {
		int id = 3535;
		member.setId(id);
		
		assertTrue(member.getId() == id);
	}
	
	@Test
	public void testSetIdHasInvalidValue() {
		int id = -8814;
		member.setId(id);
		
		assertTrue(member.getId() != id);
	}
	
	@Test
	public void testSetFullNameCheckName() {
		Name newName = new Name("Billy", "The Kid");
		FullName newFullName = new FullName(newName);
		member.setFullName(newFullName);
		
		String expected = "Billy";
		assertEquals(member.getFullName().getCommonName().getName(), expected);
	}
	
	@Test
	public void testSetFullNameCheckPatronymic() {
		Name newName = new Name("Billy", "The Kid");
		FullName newFullName = new FullName(newName);
		member.setFullName(newFullName);
		
		String expected = "";
		assertEquals(member.getFullName().getPatronymic(), expected);
	}
	
	@Test
	public void testSetFullNameCheckSurname() {
		Name newName = new Name("Billy", "The Kid");
		FullName newFullName = new FullName(newName);
		member.setFullName(newFullName);
		
		String expected = "The Kid";
		assertEquals(member.getFullName().getCommonName().getSurname(), expected);
	}
	
	@Test
	public void testSetBirthYearOne() {
		int expected = 2016;
		member.setBirthYear(expected);
		
		assertEquals(member.getBirthYear(), expected);
	}
	
	@Test
	public void testSetBirthYearTwo() {
		int expected = 3016;
		member.setBirthYear(expected);
		
		assertNotEquals(member.getBirthYear(), expected);
	}
	
	@Test
	public void testSetMother() {
		Name motherName = new Name("Feodosiya", "Paraporova");
		FullName motherFullName = new FullName(motherName, "Ivanovna");
		Member mother = new Member.Builder(motherFullName)
				.setSex(Sex.FEMALE)
				.getMember();
		
		member.setMother(mother);
		assertEquals(member.getParents().getMother(), mother);
	}
	
	@Test
	public void testSetMotherCheckIsNotNullValue() {
		member.setMother(null);
		assertNotEquals(member.getParents().getMother(), null);
	}
	
	@Test
	public void testSetFather() {
		Name fatherName = new Name("Kirill", "Lorunko");
		FullName fatherFullName = new FullName(fatherName, "Sergeevich");
		Member father = new Member.Builder(fatherFullName)
				.setSex(Sex.MALE)
				.getMember();
		
		member.setFather(father);
		assertEquals(member.getParents().getFather(), father);
	}
	
	@Test
	public void testSetFatherCheckIsNotNullValue() {
		member.setFather(null);
		assertNotEquals(member.getParents().getFather(), null);
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
	
	@Test
	public void testCheckParentValidAge() {
		Name motherName = new Name("Feodosiya", "Paraporova");
		FullName motherFullName = new FullName(motherName, "Ivanovna");
		Member mother = new Member.Builder(motherFullName)
				.setBirthYear(1967)
				.setSex(Sex.FEMALE)
				.getMember();
		
		boolean isValidAge = member.checkParentValidAge(mother);
		assertEquals(isValidAge, true);
	}
	
	@Test
	public void testCheckParentValidAgeIsNotCorrect() {
		Name motherName = new Name("Feodosiya", "Paraporova");
		FullName motherFullName = new FullName(motherName, "Ivanovna");
		Member mother = new Member.Builder(motherFullName)
				.setBirthYear(2020)
				.setSex(Sex.FEMALE)
				.getMember();
		
		boolean isValidAge = member.checkParentValidAge(mother);
		assertEquals(isValidAge, false);
	}

}
