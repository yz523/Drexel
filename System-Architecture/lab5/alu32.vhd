library IEEE;
use IEEE.std_logic_1164.all;

entity alu32 is
 port (
  a: in STD_LOGIC_vector (31 downto 0);
  b: in STD_LOGIC_vector (31 downto 0);
  c: in STD_LOGIC;
  d: in STD_LOGIC;
  op : in STD_LOGIC_vector (1 downto 0);
  result: out STD_LOGIC_vector (31 downto 0);
  c_out: out STD_LOGIC
  overflow: out STD_LOGIC
 );
end alu32;

architecture structural of alu32 is

 component alu1
  port(a,b,c_in,less,a_invert,b_invert : in std_logic;
   op : in STD_LOGIC_vector (1 downto 0);
   result,overflow,c_out : out std_logic);
 end component;


 signal s : STD_LOGIC_vector (30 downto 0);
 signal less: std_logic := '0';

begin

A1: alu1 port map (
		a(0),b(0), less,c_in,b_invert,op,result(0),s(0)
	);

Gen: for i in 1 to 30 generate
	ALUs: alu1 port map (
			a(i),b(i),less,s(i - 1),b_invert,op,result(i),s(i)
		)
	end generate;

A1: alu1 port map (
		a(31),b(31),c(30),b_invert,op,result(31),c_out,overflow
	);

end structural;
