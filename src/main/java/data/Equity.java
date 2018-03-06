package data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "symbol")
public class Equity
{

	@Id
	private int id;
	private int exchange_id;
	private String ticker;
	private String instrument;
	private String name;
	private String sector;
	private String currency;

	public Timestamp getCreated_date()
	{
		return created_date;
	}

	public void setCreated_date(Timestamp created_date)
	{
		this.created_date = created_date;
	}

	public Timestamp getLast_updated_date()
	{
		return last_updated_date;
	}

	public void setLast_updated_date(Timestamp last_updated_date)
	{
		this.last_updated_date = last_updated_date;
	}

	private Timestamp created_date;
	private Timestamp last_updated_date;

	public Equity()
	{
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public int getExchange_id()
	{
		return exchange_id;
	}

	public void setExchange_id(int exchange_id)
	{
		this.exchange_id = exchange_id;
	}

	public String getTicker()
	{
		return ticker;
	}

	public void setTicker(String ticker)
	{
		this.ticker = ticker;
	}

	public String getInstrument()
	{
		return instrument;
	}

	public void setInstrument(String instrument)
	{
		this.instrument = instrument;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getSector()
	{
		return sector;
	}

	public void setSector(String sector)
	{
		this.sector = sector;
	}

	public String getCurrency()
	{
		return currency;
	}

	public void setCurrency(String currency)
	{
		this.currency = currency;
	}


}
