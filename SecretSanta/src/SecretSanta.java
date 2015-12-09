import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

class SecretSanta {

	public static void main(String[] args) {
		List<String> names = new ArrayList<String>();

		names.add("Najae");
		names.add("Princess");
		names.add("Darius");
		names.add("Sampson");
		names.add("Victor");
		names.add("Jarrad");
		names.add("Julie");
		names.add("Khadiajah");
		names.add("Syschelle");
		names.add("Matt");
		names.add("Ken");
		names.add("Jordan");
		names.add("Rashida");
		names.add("Ed");

		for (int i = 0; i < names.size(); i++) {
			
			int ran = (int) Math.random() * 10;
			int dom = (int) Math.random() * 10;

			String personOne = names.get(ran);
			String personTwo = names.get(dom);

			write("Gifter: " + personOne + "\t" + "Recipient: " + personTwo);

		}

	}

	static void write(String pair) {

		File file = new File("notsosecretsanta");

		try (Writer writer = new BufferedWriter(new FileWriter(file, true))) {

			writer.write(pair + "\n");

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

}
