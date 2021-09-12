library IEEE;
use IEEE.std_logic_1164.all;
use IEEE.numeric_std.all;

entity tb_alu_32 is
end entity;

architecture behavioral of tb_alu_32 is

component alu32 is
 port (
  a: in STD_LOGIC;
  b: in STD_LOGIC;
  binv: in STD_LOGIC;
  aluop : in STD_LOGIC_vector (1 downto 0);
  zero: out STD_LOGIC;
  result: out STD_LOGIC_vector (31 downto 0);
  overflow: out STD_LOGIC
 );
end component;

signal a_in, b_in : STD_LOGIC_vector (31 downto 0);
signal op : STD_LOGIC_vector (3 downto 0);
signal zero_out, v_out : std_logic;
signal result_out : STD_LOGIC_vector (31 downto 0);
signal actual : integer;
signal a_int, b_int : integer := 0;

begin
  TB : alu32
   port map(
    abus => a_in,
    bbus => b_in,
    ainv => op(3),
    binv => op(2),
    aluop(1) => op(1),
    aluop(0) => op(0),
    zero => zero_out,
    result => result_out,
    overflow => v_out
    );

 op(3) <= '0' after 0 ns;
 op(2) <= '0' after 0 ns;
 op(1) <= '1' after 0 ns; -- add
 op(0) <= '0' after 0 ns; -- add

 a_int <= 
     1 after   0 ns,
     2 after 150 ns,
    -1 after 250 ns,
     0 after 450 ns,
     1 after 500 ns
;

 b_int <=
    11 after   0 ns,
    21 after 150 ns,
     1 after 250 ns,
     2 after 450 ns,
     1 after 500 ns
;
 a_in <= STD_LOGIC_vector(to_signed(a_int, 32));
 b_in <= STD_LOGIC_vector(to_signed(b_int, 32));
 actual <= to_integer(signed(result_out));


end behavioral;
