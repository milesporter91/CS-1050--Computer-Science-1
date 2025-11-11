package CS1050M05;

public class Character {
	private String name;
	private int health;
	private int level;
	private int armor;
	private int strengthScore;
	private int dexterityScore;
	private int constitutionScore;
	private int intelligenceScore;
	private int wisdomScore;
	private int charismaScore;
	private int proficiencyBonus;
	
	public Character(String name, int health, int level, int armor, int strengthScore, int dexterityScore,
			int constitutionScore, int intelligenceScore, int wisdomScore, int charismaScore, int proficiencyBonus) {
		super();
		this.name = name;
		this.health = health;
		this.level = level;
		this.armor = armor;
		this.strengthScore = strengthScore;
		this.dexterityScore = dexterityScore;
		this.constitutionScore = constitutionScore;
		this.intelligenceScore = intelligenceScore;
		this.wisdomScore = wisdomScore;
		this.charismaScore = charismaScore;
		this.proficiencyBonus = proficiencyBonus;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getArmor() {
		return armor;
	}

	public void setArmor(int armor) {
		this.armor = armor;
	}

	public int getStrengthScore() {
		return strengthScore;
	}

	public void setStrengthScore(int strengthScore) {
		this.strengthScore = strengthScore;
	}

	public int getDexterityScore() {
		return dexterityScore;
	}

	public void setDexterityScore(int dexterityScore) {
		this.dexterityScore = dexterityScore;
	}

	public int getConstitutionScore() {
		return constitutionScore;
	}

	public void setConstitutionScore(int constitutionScore) {
		this.constitutionScore = constitutionScore;
	}

	public int getIntelligenceScore() {
		return intelligenceScore;
	}

	public void setIntelligenceScore(int intelligenceScore) {
		this.intelligenceScore = intelligenceScore;
	}

	public int getWisdomScore() {
		return wisdomScore;
	}

	public void setWisdomScore(int wisdomScore) {
		this.wisdomScore = wisdomScore;
	}

	public int getCharismaScore() {
		return charismaScore;
	}

	public void setCharismaScore(int charismaScore) {
		this.charismaScore = charismaScore;
	}

	public int getProficiencyBonus() {
		return proficiencyBonus;
	}

	public void setProficiencyBonus(int proficiencyBonus) {
		this.proficiencyBonus = proficiencyBonus;
	}

	public static void main(String[] args) {
		Character character = new Character("Kalidor", 26, 3, 16, 10, 17, 14, 11, 14, 16, 2);
		int rollResult = character.rollSkillCheck(character.getModifier(character.getDexterityScore()));
		int numberOfRolls = 1;
		while (rollResult != 23) {
			rollResult = character.rollSkillCheck(character.getModifier(character.getDexterityScore()));
			numberOfRolls++;
		}
		System.out.println(rollResult);
		System.out.println("Took " + numberOfRolls + " rolls");
		
	}
	
	public int rollSkillCheck(int skillModifier) {
		int rollResult = (int)(Math.random() * 20) + 1 + skillModifier;
		
		return rollResult;
	}

	public int getModifier(int abilityScore) {
		int modifier = (int) Math.floor((abilityScore - 10) / 2);
		if (modifier < -1) {
			modifier = -1;
		}
		if (modifier > 10) {
			modifier = 10;
		}
		return modifier;
	}
}
