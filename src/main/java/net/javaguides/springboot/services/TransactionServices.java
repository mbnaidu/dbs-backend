package net.javaguides.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.models.TransactionsModel;
import net.javaguides.springboot.repositories.TransactionsRespository;

@Service
public class TransactionServices {

	@Autowired
	private TransactionsRespository transactionsRespository;
	
//	To save all customers
	public String addTransaction(TransactionsModel transactionDeatils) {
		transactionsRespository.save(transactionDeatils);
		return "saved";
	}

	public List<TransactionsModel> getAllTransaction() {
		// TODO Auto-generated method stub
		return transactionsRespository.findAll();
	}
	public boolean checkRecieverName(String banString) throws IOException{
		File file = new File("./src/main/resources/sdnlist.text");
		try(BufferedReader br = new BufferedReader(new FileReader(file))){
			String st;
			Set<String> data = new HashSet<>();
			while ((st=br.readLine()) != null)
			{
				java.util.List<String> lineData = Arrays.asList(st.split("[-+\\/.,;\"()@]"));
				lineData = lower(lineData);
				data.addAll(lineData);
			}
			java.util.List<String> nameSplit=Arrays.asList(banString.splitx("[-+\\/.,;\"()@]"));
			nameSplit = lower(nameSplit);
			for (String s:nameSplit)
			{
				if (!data.contains(s))
				{
					return(false);
				}
			}
		}
		return(true);
	}
	
	private static java.util.List<String> lower(java.util.List<String> names){
		return names.stream().map((name)->name.toLowerCase()).collect(Collectors.toList());
	}
}
