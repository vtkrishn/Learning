VendingMachine
Bucket[][] buckets = new Bucket<Stack>[][]();
Payment

Bucket
	Stack<Item>
	id - A0, A1, A2
	Capacity - 10
		stack cannot grow more than this
		stack can be empty - raise item not available

Payment
	Type
		Cash
		Card

Coin Storage
	Available amount in denominations
	insufficient blaance exception
	No change excpetion

Card Validation
	validate
	authorize pin
	post transaction

Item
	id
	name
	Type
		Drinks
		Chips
		Chocolate

Sold out Excpetion
No Change Exception

select payment(Type [card, cash])

select Item
	accept the bucket no - A0
	
